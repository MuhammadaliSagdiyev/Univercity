package uz.nt.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "fakultet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fakultet {
    @Id
    @GeneratedValue(generator = "fakultet_id_seq")
    @SequenceGenerator(name = "fakultet_id_seq", sequenceName = "fakultet_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "univercity_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Univercity univercity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fakultetId")
    private List<Group> groups;
}
