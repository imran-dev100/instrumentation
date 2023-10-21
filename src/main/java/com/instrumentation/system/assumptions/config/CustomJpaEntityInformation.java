package com.instrumentation.system.assumptions.config;

import java.util.Collection;
import java.util.Map;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Component;
import jakarta.persistence.metamodel.SingularAttribute;

//Enabling for REPLAY mode only
@Profile("REPLAY")
@Component
public class CustomJpaEntityInformation<T, ID> implements JpaEntityInformation<T, ID> {

	@Override
	public boolean isNew(T entity) {
		return false;
	}

	@Override
	public ID getId(T entity) {
		return null;
	}

	@Override
	public Class<ID> getIdType() {
		return null;
	}

	@Override
	public Class<T> getJavaType() {
		return null;
	}

	@Override
	public String getEntityName() {
		return null;
	}

	@Override
	public SingularAttribute<? super T, ?> getIdAttribute() {
		return null;
	}

	@Override
	public boolean hasCompositeId() {
		return false;
	}

	@Override
	public Collection<String> getIdAttributeNames() {
		return null;
	}

	@Override
	public Object getCompositeIdAttributeValue(Object id, String idAttribute) {
		return null;
	}

	@Override
	public Map<String, Object> getKeyset(Iterable<String> propertyPaths, T entity) {
		return null;
	}

}
