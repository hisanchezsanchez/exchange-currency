package hider.sanchez.challengebcp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "change")
public class Change {
    @Id
    @Column(name = "change_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer changeId;
    @Column(name = "change_type")
    private Double changeType;
    @Column(name = "currency_code")
    private String currencyCode;
    private Date date;
}
