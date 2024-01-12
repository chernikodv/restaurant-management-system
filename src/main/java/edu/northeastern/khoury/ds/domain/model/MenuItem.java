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
import jakarta.persistence.ParameterMode;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "menu_item")
@NamedStoredProcedureQuery(
        name = "menu_item_nutrition_facts",
        procedureName = "menu_item_nutrition_facts",
        resultSetMappings="NutritionFactsResultSetMapping",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "menu_item_id", type = Integer.class)
        }
)
@NamedStoredProcedureQuery(
        name = "menu_item_average_nutrition_facts",
        procedureName = "menu_item_average_nutrition_facts",
        resultSetMappings="NutritionFactsResultSetMapping",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "menu_item_id", type = Integer.class)
        }
)
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private BigDecimal price;
    private String description;

    @ToString.Exclude
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "menuItem")
    private List<MenuItemIngredient> ingredients = new ArrayList<>();
}
