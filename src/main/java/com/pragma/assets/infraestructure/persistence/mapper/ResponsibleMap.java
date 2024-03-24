package com.pragma.assets.infraestructure.persistence.mapper;

import com.pragma.assets.application.dto.*;
import com.pragma.assets.domain.entity.*;
import com.pragma.assets.infraestructure.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class ResponsibleMap implements ResponsibleMapper {
    @Override
    public Responsible entityToResponsible(ResponsibleEntity responsibleEntity) {

        if (responsibleEntity instanceof SpecificEmployeeEntity) {
            return specificEmployeeEntityToResponsible((SpecificEmployeeEntity) responsibleEntity);
        } else if (responsibleEntity instanceof CollaboratorEntity) {
            return collaboratorEntityToResponsible((CollaboratorEntity) responsibleEntity);
        } else if (responsibleEntity instanceof EmployeeEntity) {
            return employeeEntityToResponsible((EmployeeEntity) responsibleEntity);
        } else if (responsibleEntity instanceof FacilitiesEntity) {
            return facilitiesEntityToResponsible((FacilitiesEntity) responsibleEntity);
        }
        return responsibleEntityToResponsible(responsibleEntity);
    }

    private Responsible specificEmployeeEntityToResponsible(SpecificEmployeeEntity specificEmployeeEntity) {
        return new SpecificEmployee(specificEmployeeEntity.getId(), specificEmployeeEntity.getEmail(), specificEmployeeEntity.getFullName(),
                specificEmployeeEntity.getDocumentType(), specificEmployeeEntity.getDocumentNumber(),
                new Company(specificEmployeeEntity.getCompany().getName(), specificEmployeeEntity.getCompany().getNit(),
                        specificEmployeeEntity.getCompany().getLocation()), specificEmployeeEntity.getTypeOfContract(),
                specificEmployeeEntity.getRole(), specificEmployeeEntity.getBusinessEmail(),
                specificEmployeeEntity.getSalary());
    }

    private Responsible collaboratorEntityToResponsible(CollaboratorEntity collaboratorEntity) {
        return new Collaborator(collaboratorEntity.getId(), collaboratorEntity.getEmail(),
                collaboratorEntity.getFullName(), collaboratorEntity.getDocumentType(),
                collaboratorEntity.getDocumentNumber(), new Company(collaboratorEntity.getCompany().getName(),
                collaboratorEntity.getCompany().getNit(), collaboratorEntity.getCompany().getLocation()),
                collaboratorEntity.getServiceDescription(), collaboratorEntity.getEndDateService(),
                collaboratorEntity.getFullPaymentService(), collaboratorEntity.getCurrency());
    }

    private Responsible employeeEntityToResponsible(EmployeeEntity employeeEntity) {
        return new Employee(employeeEntity.getId(), employeeEntity.getEmail(), employeeEntity.getFullName(), employeeEntity.getDocumentType(),
                employeeEntity.getDocumentNumber(), new Company(employeeEntity.getCompany().getName(),
                employeeEntity.getCompany().getNit(), employeeEntity.getCompany().getLocation()));
    }


    private Responsible facilitiesEntityToResponsible(FacilitiesEntity facilitiesEntity) {
        return new Facilities(facilitiesEntity.getId(), facilitiesEntity.getName(), facilitiesEntity.getCity(),
                facilitiesEntity.getAddress());
    }

    private Responsible responsibleEntityToResponsible(ResponsibleEntity responsibleEntity) {
        return new Responsible(responsibleEntity.getId());
    }

    @Override
    public ResponsibleEntity responsibleToEntity(Responsible responsible) {
        if (responsible instanceof SpecificEmployee) {
            return specificEmployeeToResponsibleEntity((SpecificEmployee) responsible);
        } else if (responsible instanceof Collaborator) {
            return collaboratorToResponsibleEntity((Collaborator) responsible);
        } else if (responsible instanceof Employee) {
            return employeeToResponsibleEntity((Employee) responsible);
        } else if (responsible instanceof Facilities) {
            return facilitiesToResponsibleEntity((Facilities) responsible);
        }
        return responsibleToResponsibleEntity(responsible);
    }

    private ResponsibleEntity specificEmployeeToResponsibleEntity(SpecificEmployee specificEmployee) {
        return new SpecificEmployeeEntity(specificEmployee.getId(), specificEmployee.getEmail(),
                specificEmployee.getFullName(), specificEmployee.getDocumentType(),
                specificEmployee.getDocumentNumber(), new CompanyEntity(specificEmployee.getCompany().getName(),
                specificEmployee.getCompany().getNit(), specificEmployee.getCompany().getLocation()),
                specificEmployee.getTypeOfContract(), specificEmployee.getRole(),
                specificEmployee.getBusinessEmail(), specificEmployee.getSalary());
    }

    private ResponsibleEntity collaboratorToResponsibleEntity(Collaborator collaborator) {
        return new CollaboratorEntity(collaborator.getId(), collaborator.getEmail(),
                collaborator.getFullName(), collaborator.getDocumentType(),
                collaborator.getDocumentNumber(), new CompanyEntity(collaborator.getCompany().getName(),
                collaborator.getCompany().getNit(), collaborator.getCompany().getLocation()),
                collaborator.getServiceDescription(), collaborator.getEndDateService(),
                collaborator.getFullPaymentService(), collaborator.getCurrency());
    }

    private ResponsibleEntity employeeToResponsibleEntity(Employee employee) {
        return new EmployeeEntity(employee.getId(), employee.getEmail(), employee.getFullName(), employee.getDocumentType(),
                employee.getDocumentNumber(), new CompanyEntity(employee.getCompany().getName(),
                employee.getCompany().getNit(), employee.getCompany().getLocation()));
    }

    private ResponsibleEntity facilitiesToResponsibleEntity(Facilities facilities) {
        return new FacilitiesEntity(facilities.getId(), facilities.getName(), facilities.getCity(),
                facilities.getAddress());
    }

    private ResponsibleEntity responsibleToResponsibleEntity(Responsible responsible) {
        return new ResponsibleEntity(responsible.getId());
    }

    @Override
    public Responsible dtoToResponsible(ResponsibleDTO responsibleDTO) {
        if (responsibleDTO instanceof SpecificEmployeeDTO) {
            return specificEmployeeDTOToResponsible((SpecificEmployeeDTO) responsibleDTO);
        } else if (responsibleDTO instanceof CollaboratorDTO) {
            return collaboratorDTOToResponsible((CollaboratorDTO) responsibleDTO);
        } else if (responsibleDTO instanceof EmployeeDTO) {
            return employeeDTOToResponsible((EmployeeDTO) responsibleDTO);
        } else if (responsibleDTO instanceof FacilitiesDTO) {
            return facilitiesDTOToResponsible((FacilitiesDTO) responsibleDTO);
        }
        return responsibleDTOToResponsible(responsibleDTO);
    }

    private Responsible specificEmployeeDTOToResponsible(SpecificEmployeeDTO specificEmployeeDTO) {
        return new SpecificEmployee(specificEmployeeDTO.getId(), specificEmployeeDTO.getEmail(), specificEmployeeDTO.getFullName(),
                specificEmployeeDTO.getDocumentType(), specificEmployeeDTO.getDocumentNumber(),
                new Company(specificEmployeeDTO.getCompanyDTO().getName(), specificEmployeeDTO.getCompanyDTO().getNit(),
                        specificEmployeeDTO.getCompanyDTO().getLocation()), specificEmployeeDTO.getTypeOfContract(),
                specificEmployeeDTO.getRole(), specificEmployeeDTO.getBusinessEmail(),
                specificEmployeeDTO.getSalary());
    }

    private Responsible collaboratorDTOToResponsible(CollaboratorDTO collaboratorDTO) {
        return new Collaborator(collaboratorDTO.getId(), collaboratorDTO.getEmail(),
                collaboratorDTO.getFullName(), collaboratorDTO.getDocumentType(),
                collaboratorDTO.getDocumentNumber(), new Company(collaboratorDTO.getCompanyDTO().getName(),
                collaboratorDTO.getCompanyDTO().getNit(), collaboratorDTO.getCompanyDTO().getLocation()),
                collaboratorDTO.getServiceDescription(), collaboratorDTO.getEndDateService(),
                collaboratorDTO.getFullPaymentService(), collaboratorDTO.getCurrency());
    }

    private Responsible employeeDTOToResponsible(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getEmail(), employeeDTO.getFullName(), employeeDTO.getDocumentType(),
                employeeDTO.getDocumentNumber(), new Company(employeeDTO.getCompanyDTO().getName(),
                employeeDTO.getCompanyDTO().getNit(), employeeDTO.getCompanyDTO().getLocation()));
    }


    private Responsible facilitiesDTOToResponsible(FacilitiesDTO facilitiesDTO) {
        return new Facilities(facilitiesDTO.getId(), facilitiesDTO.getName(), facilitiesDTO.getCity(),
                facilitiesDTO.getAddress());
    }

    private Responsible responsibleDTOToResponsible(ResponsibleDTO responsibleDTO) {
        return new Responsible(responsibleDTO.getId());
    }


}