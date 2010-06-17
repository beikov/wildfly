/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.domain;

import java.io.Serializable;
import org.jboss.as.model.AbstractModelUpdate;
import org.jboss.as.server.Server;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public abstract class AbstractDomainUpdate<R> extends AbstractModelUpdate<R> implements Serializable {

    private static final long serialVersionUID = -46837337005143198L;

    protected AbstractDomainUpdate(final Class<R> resultType, final long beforeChecksum, final long afterChecksum) {
        super(resultType, beforeChecksum, afterChecksum);
    }

    protected abstract void applyUpdate(Domain domain, Object token);

    protected abstract R applyUpdate(Server server, Object token);

    protected abstract void revertFrom(Domain domain);

    protected abstract R revertFrom(Server server);
}
