package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
@NamedStoredProcedureQuery(
        name = "category_average_nutrition_facts",
        procedureName = "category_average_nutrition_facts",
        resultSetMappings="NutritionFactsResultSetMapping",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "category_id", type = Integer.class)
        }
)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
