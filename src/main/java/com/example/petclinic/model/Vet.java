package com.example.petclinic.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "Vet")
@Table(name = "vet")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ElementCollection(targetClass=Speciality.class)
    @Enumerated(EnumType.ORDINAL)
    @CollectionTable(name="specialities")
    @Column(name="speciality")
    private List<Speciality> specialities;

    // TODO implement many to many
    //private List<Visit> visits;

    protected Vet() {

    }

    public Vet(String name, List<Speciality> specialities) {
        this.name = name;
        this.specialities = specialities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vet vet = (Vet) o;
        return Objects.equals(id, vet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vet{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", specialities=").append(specialities);
        sb.append('}');
        return sb.toString();
    }

    public static VetBuilder builder() {
        return new VetBuilder();
    }

    public static final class VetBuilder {

        private Vet vet;

        private VetBuilder() {
            vet = new Vet();
        }

        public VetBuilder withName(String name) {
            vet.setName(name);
            return this;
        }

        public VetBuilder withSpecialities(List<Speciality> specialities) {
            vet.setSpecialities(specialities);
            return this;
        }

        public Vet build() {
            return vet;
        }
    }
}
