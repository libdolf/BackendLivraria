package br.libdolf.backendlivraria.validations;

import br.com.caelum.stella.validation.CPFValidator;
import br.libdolf.backendlivraria.DTOs.RequestAutorDTO;
import br.libdolf.backendlivraria.exceptions.BadRequestException;
import br.libdolf.backendlivraria.utils.Country;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryMatchesCPFValidator implements ConstraintValidator<CountryMatchesCPF, RequestAutorDTO>{
    @Override
    public void initialize(CountryMatchesCPF constraintAnnotation) {
    }

    @Override
    public boolean isValid(RequestAutorDTO autorDTO, ConstraintValidatorContext context) {
        if (autorDTO.getCountry() == Country.BRA) {
            // Se o país for o Brasil, o CPF deve ser obrigatório
            String cpf = autorDTO.getCpf();
            if (cpf != null && !cpf.isEmpty()) {
                // Verifica se o CPF está formatado corretamente
                if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                    return false;
                }
                // Verifica se o CPF é válido
                return isValidCPF(cpf);
            } else {
                return false;
            }
        }
        return true; // Para outros países, não há restrição de CPF
    }

    private boolean isValidCPF(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try{ cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            throw new BadRequestException("CPF inválido");
        }
    }
}

