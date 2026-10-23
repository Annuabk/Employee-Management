package Employee.Management.application.specification;

import Employee.Management.application.enums.EntityStatus;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.text.MessageFormat;

public abstract class EmployeeSpecification <T> {

    protected static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }

    protected Specification<T> query(String expression) {
        if(StringUtils.isBlank(expression))   return (root, query, builder) -> builder.conjunction();
        return (root, query, builder) ->
                builder.or(builder.like(root.get("name"),contains(expression)));

    }

    public Specification<T> entityStatus(EntityStatus[] entityStatuses) {
        if (entityStatuses == null || entityStatuses.length == 0) return null;
        return (root, query, builder) -> {
            if (entityStatuses.length == 1) return builder.equal(root.get("status"), entityStatuses[0]);
            return root.get("status").in((Object[]) entityStatuses);
        };
    }

        protected Specification<T> companyId(String companyId) {
            if (StringUtils.isBlank(companyId)) return null;
            return (root, query, builder) -> builder.equal(root.get("companyId"), companyId);
        }

        protected Specification<T> siteId(String siteId) {
            if (StringUtils.isBlank(siteId)) return null;
            return (root, query, builder) -> builder.equal(root.get("siteId"), siteId);
        }
    }


