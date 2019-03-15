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
package org.apache.commons.pool2;

/**
 * 池化对象的状态
 *
 * Provides the possible states that a {@link PooledObject} may be in.
 *
 * @since 2.0
 */
public enum PooledObjectState {
    /**
     * In the queue, not in use.
     * 在资源池中，没有被使用，处于空闲状态
     */
    IDLE,

    /**
     * In use.
     * 已激活，正在被使用
     */
    ALLOCATED,

    /**
     * In the queue, currently being tested for possible eviction.
     * 在资源池中，正在检测是否被清除
     */
    EVICTION,

    /**
     * Not in the queue, currently being tested for possible eviction. An
     * attempt to borrow the object was made while being tested which removed it
     * from the queue. It should be returned to the head of the queue once
     * eviction testing completes.
     * TODO: Consider allocating object and ignoring the result of the eviction
     *       test.
     */
    EVICTION_RETURN_TO_HEAD,

    /**
     * In the queue, currently being validated.
     */
    VALIDATION,

    /**
     * Not in queue, currently being validated. The object was borrowed while
     * being validated and since testOnBorrow was configured, it was removed
     * from the queue and pre-allocated. It should be allocated once validation
     * completes.
     */
    VALIDATION_PREALLOCATED,

    /**
     * Not in queue, currently being validated. An attempt to borrow the object
     * was made while previously being tested for eviction which removed it from
     * the queue. It should be returned to the head of the queue once validation
     * completes.
     */
    VALIDATION_RETURN_TO_HEAD,

    /**
     * Failed maintenance (e.g. eviction test or validation) and will be / has
     * been destroyed
     */
    INVALID,

    /**
     * Deemed abandoned, to be invalidated.
     */
    ABANDONED,

    /**
     * Returning to the pool.
     */
    RETURNING
}
