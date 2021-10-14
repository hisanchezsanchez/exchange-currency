package hider.sanchez.challengebcp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "currency")
public class Currency {
    @Id
    @Column(name = "currency_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer currencyId;
    private String code;
    private String symbol;
    private String name;
}
