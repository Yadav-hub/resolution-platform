package com.aman.resolutionplatform.Controller.Ticket;
import com.aman.resolutionplatform.DTO.Ticket.TicketResponseDTO;
import org.springframework.web.bind.annotation.RestController;
import com.aman.resolutionplatform.DTO.Ticket.TicketRequestDTO;
import com.aman.resolutionplatform.DTO.Ticket.UpdateTicketStatusDTO;
import com.aman.resolutionplatform.Enum.Ticket.Department;
import com.aman.resolutionplatform.Enum.Ticket.TicketStatus;
import com.aman.resolutionplatform.Services.Ticket.TicketService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Set;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@Validated
@RestController
public class TicketController {

    private final TicketService ticketService;

    public static final Set<String> Allowed_Sort_Fields = Set.of("createdAt",
            "ticketStatus",
            "severityType",
            "department");

    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket/{ticket_id}")
    public ResponseEntity<TicketResponseDTO> getTicketById(@PathVariable @Valid Integer ticket_id)
    {
        return ResponseEntity.ok(ticketService.getTicketById(ticket_id));
    }
    

    @PostMapping("/ticket")
    public ResponseEntity<TicketResponseDTO> createTicket(@RequestBody @Valid TicketRequestDTO ticketDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.createTicket(ticketDTO));
    }
    
    @GetMapping("/ticket")
    public ResponseEntity<Page<TicketResponseDTO>> getAllTickets(@PositiveOrZero @RequestParam(defaultValue = "0") Integer page, @Positive @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "createdAt") String sortBy, @RequestParam(defaultValue = "DESC") String sortOrder) {
        if(!Allowed_Sort_Fields.contains(sortBy))
        {
            throw new IllegalArgumentException("Invalid Sort field: "+sortBy);
        }
        Sort sort = Sort.by(
                Sort.Direction.fromString(sortOrder),
                sortBy);
        Pageable pageable = PageRequest.of(page, size,sort);
        
        return ResponseEntity.ok(ticketService.getAllTickets(pageable));
    }
    
    
    @PutMapping("ticket/{ticketId}/status")
    public ResponseEntity<TicketResponseDTO> updateTicketStatus(@PathVariable
        @Positive(message = "Ticket id must be greater than 0") Integer ticketId, @RequestBody @Valid UpdateTicketStatusDTO ticketStatus) {
        
    
        return ResponseEntity.ok(ticketService.updateTicketStatus(ticketId, ticketStatus.getTicketStatus()));
    }

    @GetMapping("/ticket/status/{status}")
    public ResponseEntity<List<TicketResponseDTO>> findByTicketStatus(@PathVariable TicketStatus status) {
        return ResponseEntity.ok(ticketService.findByTicketStatus(status));
    }

    @GetMapping("/ticket/department/{department}")
    public ResponseEntity<List<TicketResponseDTO>> findByDepartment(@PathVariable Department department) {
        return ResponseEntity.ok(ticketService.findByDepartment(department));
    }
    
    @GetMapping("/ticket/department/{department}/status/{status}")
    public ResponseEntity<List<TicketResponseDTO>> findByDepartmentAndTicketStatus(@PathVariable Department department,@PathVariable("status") TicketStatus ticketStatus) {
           
        return ResponseEntity.ok(ticketService.findByDepartmentAndTicketStatus(department,ticketStatus));
    }
}

