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
    @Column(name = "origin_currency_id")
    private Integer origenCurrencyId;
    @Column(name = "destination_currency_id")
    private Integer destinationCurrencyId;
    @Column(name = "change_type")
    private Double changeType;
    private String operation;
    private Boolean active;
    private Date date;
}
