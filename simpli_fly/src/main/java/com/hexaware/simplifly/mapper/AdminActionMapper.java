package com.hexaware.simplifly.mapper;


import com.hexaware.simplifly.exceptions.*;
import com.hexaware.simplifly.dto.AdminActionDTO;
import com.hexaware.simplifly.entities.AdminAction;
import com.hexaware.simplifly.entities.User;
import com.hexaware.simplifly.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminActionMapper {

    @Autowired
    private UserRepository userRepository;

    public AdminActionDTO toDTO(AdminAction adminAction) {
        AdminActionDTO adminActionDTO = new AdminActionDTO();
        adminActionDTO.setActionId(adminAction.getActionId());
        adminActionDTO.setAdminId(adminAction.getAdmin().getUserId());
        adminActionDTO.setActionType(adminAction.getActionType());
        adminActionDTO.setActionDetails(adminAction.getActionDetails());
        adminActionDTO.setActionTimestamp(adminAction.getActionTimestamp());
        return adminActionDTO;
    }

    public AdminAction toEntity(AdminActionDTO adminActionDTO) throws ResourceNotFoundException {
        User admin = userRepository.findById(adminActionDTO.getAdminId())
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with ID: " + adminActionDTO.getAdminId()));

        AdminAction adminAction = new AdminAction(
                adminActionDTO.getActionId(),
                admin,
                adminActionDTO.getActionType(),
                adminActionDTO.getActionDetails(),
                adminActionDTO.getActionTimestamp()
        );

        return adminAction;
    }
}
