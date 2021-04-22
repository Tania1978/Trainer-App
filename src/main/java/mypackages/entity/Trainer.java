/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackages.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import mypackages.validator.Age;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author tania
 */
@Entity
@Table(name = "trainers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t"),
    @NamedQuery(name = "Trainer.findById", query = "SELECT t FROM Trainer t WHERE t.id = :id"),
    @NamedQuery(name = "Trainer.findByVatNumber", query = "SELECT t FROM Trainer t WHERE t.vatNumber = :vatNumber"),
    @NamedQuery(name = "Trainer.findByFirstName", query = "SELECT t FROM Trainer t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "Trainer.findByLastName", query = "SELECT t FROM Trainer t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "Trainer.findByDateofBirth", query = "SELECT t FROM Trainer t WHERE t.dateofBirth = :dateofBirth"),
    @NamedQuery(name = "Trainer.findBySubject", query = "SELECT t FROM Trainer t WHERE t.subject = :subject")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
     @Min(value=100000000, message="Enter a valid Vat Number (max 9 digits - first digit cannot be 0)")  
    @Max(value=999999999, message="Enter a valid Vat Number (max 9 digits)")  
    @Column(name = "vat_number")
    private int vatNumber;
    @Basic(optional = false)
    @NotNull
    @NotEmpty(message="Please enter your First Name ")
    @Size(min = 2, max = 30, message="Please enter at least 2 characters!")
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
      @NotEmpty(message="Please enter your Last Name ")
    @Size(min = 2, max = 30, message="Please enter at least 2 characters!")
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_Birth")
   @NotNull(message="Please enter your Date of Birth ")
    @Age(value=18, message="Valid Age for a Trainer is over 18 years old.")
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private LocalDate dateofBirth;
    @Size(max = 20)
    @Column(name = "subject")
    private String subject;

    public Trainer() {
    }

    public Trainer(Integer id) {
        this.id = id;
    }

    public Trainer(Integer id, int vatNumber, String firstName, String lastName) {
        this.id = id;
        this.vatNumber = vatNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mypackages.entity.Trainers[ id=" + id + " ]";
    }
    
}
