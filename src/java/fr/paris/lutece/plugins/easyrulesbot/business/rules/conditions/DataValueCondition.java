/*
 * Copyright (c) 2002-2015, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.easyrulesbot.business.rules.conditions;

import java.util.Map;


/**
 * DataValueCondition
 */
public class DataValueCondition implements Condition
{
    private static final String UNDEFINED = "undefined";

    // Variables declarations 
    private String _strDataKey;
    private String _strDataValue;

    /**
     * Returns the DataKey
     * @return The DataKey
     */
    public String getDataKey(  )
    {
        return _strDataKey;
    }

    /**
     * Sets the DataKey
     * @param strDataKey The DataKey
     */
    public void setDataKey( String strDataKey )
    {
        _strDataKey = strDataKey;
    }

    /**
     * Returns the DataValue
     * @return The DataValue
     */
    public String getDataValue(  )
    {
        return _strDataValue;
    }

    /**
     * Sets the DataValue
     * @param strDataValue The DataValue
     */
    public void setDataValue( String strDataValue )
    {
        _strDataValue = strDataValue;
    }

    @Override
    public boolean evaluate( Map<String, String> mapData, String strRuleDataKey )
    {
        if ( UNDEFINED.equalsIgnoreCase( _strDataValue ) )
        {
            return !mapData.containsKey( _strDataKey );
        }

        String strValue = mapData.get( _strDataKey );

        return _strDataValue.equals( strValue );
    }
}
