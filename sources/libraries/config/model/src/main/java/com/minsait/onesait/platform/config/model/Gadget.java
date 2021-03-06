/**
 * Copyright Indra Soluciones Tecnologías de la Información, S.L.U.
 * 2013-2019 SPAIN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.minsait.onesait.platform.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Configurable;

import com.minsait.onesait.platform.config.model.base.OPResource;

import lombok.Getter;
import lombok.Setter;

@Configurable
@Entity
@Table(name = "GADGET", uniqueConstraints= @UniqueConstraint(name = "UK_IDENTIFICATION", columnNames={"IDENTIFICATION"}))

public class Gadget extends OPResource {

	private static final long serialVersionUID = 1L;

	@Column(name = "TYPE", length = 45, nullable = false)
	@Getter
	@Setter
	private String type;

	@Column(name = "DESCRIPTION", length = 512)
	@Getter
	@Setter
	private String description;

	@Column(name = "PUBLIC", nullable = false, columnDefinition = "BIT")
	@Getter
	@Setter
	private boolean isPublic;

	@Column(name = "CONFIG")
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Getter
	@Setter
	private String config;
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Gadget))
			return false;
		return getIdentification() != null && getIdentification().equals(((Gadget) o).getIdentification());
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(getIdentification());
	}
}
