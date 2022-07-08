package uz.nt.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "univercity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Univercity {
    @Id
    @GeneratedValue(generator = "univercity_id_seq")
    @SequenceGenerator(name = "univercity_id_seq", sequenceName = "univercity_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "openYear")
    private Date openYear;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "univercity")
    private List<Fakultet> fakultets;
}
