package com.aman.resolutionplatform.Services.Ticket.TicketServiceImpl;
import java.util.List;
import com.aman.resolutionplatform.DTO.Ticket.TicketResponseDTO;
import com.aman.resolutionplatform.mapper.TicketMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aman.resolutionplatform.DTO.Ticket.TicketDTO;
import com.aman.resolutionplatform.Enum.Ticket.Department;
import com.aman.resolutionplatform.Enum.Ticket.TicketStatus;
import com.aman.resolutionplatform.Exception.FeedbackNotFoundException;
import com.aman.resolutionplatform.Exception.TicketNotFoundException;
import com.aman.resolutionplatform.Model.Feedback.Feedback;
import com.aman.resolutionplatform.Model.Ticket.Ticket;
import com.aman.resolutionplatform.Repository.Feedback.FeedbackRepo;
import com.aman.resolutionplatform.Repository.Ticket.TicketRepo;
import com.aman.resolutionplatform.Services.Ticket.TicketService;

@Service
public class TicketServiceImple implements TicketService{

    private final FeedbackRepo feedbackRepo;
    private final TicketRepo ticketRepo;

    private final TicketMapper ticketMapper;

    TicketServiceImple(TicketRepo ticketRepo, FeedbackRepo feedbackRepo, TicketMapper ticketMapper)
    {
        this.ticketRepo = ticketRepo;
        this.feedbackRepo = feedbackRepo;
        this.ticketMapper = ticketMapper;
    }




    public TicketResponseDTO createTicket(TicketDTO ticketDTO) {
        
        Integer feedback_id = ticketDTO.getFeedbackId();

        Feedback feedback = feedbackRepo.findById(feedback_id)
        .orElseThrow(() -> 
        new FeedbackNotFoundException("Feedback not found with id : "+feedback_id));

        Ticket ticket= new Ticket();     
        ticket.setFeedback(feedback);
        ticket.setDepartment(ticketDTO.getDepartment());
        ticket.setSeverityType(ticketDTO.getSeverityType());
        ticket.setIssueInfo(ticketDTO.getIssueInfo());

        Ticket savedTicket = ticketRepo.save(ticket);

        return ticketMapper.convertToDTO(savedTicket);
    }


    public TicketResponseDTO getTicketById(Integer ticket_id)
    {
        Ticket ticket = ticketRepo.findById(ticket_id)
        .orElseThrow(()-> 
        new TicketNotFoundException("Ticket not found with id : "+ticket_id));

        return ticketMapper.convertToDTO(ticket);
    }

    public Page<TicketResponseDTO> getAllTickets(Pageable pageable)
    {

        return ticketRepo.findAll(pageable).map(ticketMapper::convertToDTO);
    }

    public TicketResponseDTO updateTicketStatus(Integer ticket_id, TicketStatus status)
    {
        Ticket ticket = ticketRepo.findById(ticket_id).orElseThrow(()-> new TicketNotFoundException("Ticket not found with id : "+ ticket_id));

        ticket.setTicketStatus(status);
        return ticketMapper.convertToDTO(ticketRepo.save(ticket));
    }

    public List<TicketResponseDTO> findByTicketStatus(TicketStatus status)
    {  
        List<Ticket> ticket = ticketRepo.findByTicketStatus(status);

        return ticket
                .stream()
                .map(ticketMapper::convertToDTO)
                .toList();
    }
    
    public List<TicketResponseDTO> findByDepartment(Department department)
    {
        return ticketRepo
                .findByDepartment(department)
                .stream()
                .map(ticketMapper::convertToDTO)
                .toList();
    }

    public List<TicketResponseDTO> findByDepartmentAndTicketStatus(Department department , TicketStatus ticketStatus)
    {
        return ticketRepo
                .findByDepartmentAndTicketStatus(department, ticketStatus)
                .stream()
                .map(ticketMapper::convertToDTO)
                .toList();

    }


}
