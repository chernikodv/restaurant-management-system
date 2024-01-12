package edu.northeastern.khoury.ds.domain.model;

import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "online_order")
@NamedStoredProcedureQuery(
        name = "order_nutrition_facts",
        procedureName = "order_nutrition_facts",
        resultSetMappings="NutritionFactsResultSetMapping",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "online_order_id", type = Integer.class)
        }
)
@SqlResultSetMapping(
        name = "NutritionFactsResultSetMapping",
        classes = {
                @ConstructorResult(
                        targetClass = NutritionFacts.class,
                        columns = {
                                @ColumnResult(name = "fat", type = Integer.class),
                                @ColumnResult(name = "protein", type = Integer.class),
                                @ColumnResult(name = "carbohydrate", type = Integer.class),
                                @ColumnResult(name = "calories", type = Integer.class)
                        }
                )
        }
)
public class OnlineOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal tip;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    @ToString.Exclude
    @JoinColumn(name = "username")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ToString.Exclude
    @JoinColumn(name = "employee_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @ToString.Exclude
    @OneToMany(mappedBy = "onlineOrder")
    public List<OnlineOrderInfo> onlineOrderInfo;
}
