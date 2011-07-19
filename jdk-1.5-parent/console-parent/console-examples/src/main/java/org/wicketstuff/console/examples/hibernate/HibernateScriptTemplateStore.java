/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wicketstuff.console.examples.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.console.engine.Lang;
import org.wicketstuff.console.templates.IScriptTemplateStore;
import org.wicketstuff.console.templates.ScriptTemplate;

/**
 * @author cretzel
 * 
 */
public class HibernateScriptTemplateStore implements IScriptTemplateStore
{

	private static final long serialVersionUID = 1L;

	@SpringBean
	private HibernateScriptTemplateDao dao;

	public HibernateScriptTemplateStore()
	{
		Injector.get().inject(this);
	}

	public void save(final ScriptTemplate t)
	{
		dao.save(PersistentScriptTemplate.fromScriptTemplate(t));
	}

	public ScriptTemplate getById(final Long id)
	{
		final PersistentScriptTemplate persistentTemplate = dao.get(id);
		final ScriptTemplate scriptTemplate = persistentTemplate != null
			? persistentTemplate.toScriptTemplate() : null;

		return scriptTemplate;
	}

	public List<ScriptTemplate> findAll(final Lang lang)
	{
		final List<PersistentScriptTemplate> list = dao.findAll(lang);

		final List<ScriptTemplate> result = new ArrayList<ScriptTemplate>();
		for (final PersistentScriptTemplate t : list)
		{
			result.add(t.toScriptTemplate());
		}

		return result;
	}

	public boolean readOnly()
	{
		return false;
	}

	public void detach()
	{
	}


}
