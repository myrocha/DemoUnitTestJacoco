package com.example.workshoptest



import com.example.workshoptest.viewmodel.ValidatorRegister
import org.junit.Assert.*
import org.junit.Test

class RegisterValidatorTest {



    /**
     * testa um nome valido
     */
    @Test
    fun givenValidName_whenValidateName_shouldReturnTrue() {
        assertTrue(ValidatorRegister.validateName("Ana"))
    }

    /**
     * testa um nome em branco
     */
    @Test
    fun givenBlanckName_whenValidateName_shouldReturnFalse() {
        assertFalse(ValidatorRegister.validateName("  "))
    }

    /**
     * testa um nome vazio
     */
    @Test
    fun givenRegisterWithNameEmpty_whenValidateRegister_shouldReturnFalse() {
        assertFalse(ValidatorRegister.validateName(""))
    }



    /**
     * testa um cpf valido
     */
    @Test
    fun givenValidCpf_whenValidateCpf_shouldReturnTrue(){
        assertTrue(ValidatorRegister.validateCpf("98523171215"))
    }

    /**
     * testa um cpf invalido
     */
    @Test
    fun giveInvalidCpf_whenValidateCpf_shouldReturnFalse(){
        assertFalse(ValidatorRegister.validateCpf("99999999999999999999999999999999999"))
    }

    /**
     * testa um cpf em branco
     */
    @Test
    fun givenBlankCpf_whenValidateCpf_shouldReturnFalse(){
        assertFalse(ValidatorRegister.validateCpf("   "))
    }

    /**
     * testa um email valido
     */

    @Test
    fun givenValidEmail_whenValidateEmail_shouldReturnTrue(){
        assertTrue(ValidatorRegister.validateEmail("ana.silva@gmail.com"))
    }

    /**
     * testa um email em branco
     */
    @Test
    fun givenBlankEmail_whenValidateEmail_shouldReturnFalse(){
        assertFalse(ValidatorRegister.validateEmail("   "))
    }

    /**
     * testa um email invalido
     */

    @Test
    fun givenInvalidEmail_whenValidateEmail_shouldReturnFalse(){
     assertFalse(ValidatorRegister.validateEmail("ana.silvagmail.com"))
    }






}