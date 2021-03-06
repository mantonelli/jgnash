/*
 * jGnash, a personal finance application
 * Copyright (C) 2001-2014 Craig Cavanaugh
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jgnash.convert.imports.ofx;

import java.math.BigDecimal;
import java.util.Date;

import jgnash.convert.imports.ImportBank;
import jgnash.convert.imports.ImportTransaction;

/**
 * OFX Bank Object
 * 
 * @author Craig Cavanaugh
 * @author Nicolas Bouillon
 */
public class OfxBank extends ImportBank {

    public String currency;

    public String bankId;

    /**
     * Branch identifier. May be required for some non-US banks
     */
    public String branchId;

    public String accountId;

    public String accountType;

    public Date dateStart;

    public Date dateEnd;

    public BigDecimal ledgerBalance;

    public Date ledgerBalanceDate;

    private BigDecimal availBalance;

    private Date availBalanceDate;

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("currency: ").append(currency).append('\n');
        b.append("bankId: ").append(bankId).append('\n');
        b.append("accountId: ").append(accountId).append('\n');
        b.append("accountType: ").append(accountType).append('\n');
        b.append("dateStart: ").append(dateStart.toString()).append('\n');
        b.append("dateEnd: ").append(dateEnd.toString()).append('\n');
        b.append("ledgerBalance: ").append(ledgerBalance.toString()).append('\n');
        b.append("ledgerBalanceDate: ").append(ledgerBalanceDate.toString()).append('\n');

        if (availBalance != null) {
            b.append("availBalance: ").append(availBalance.toString()).append('\n');
        }

        if (availBalanceDate != null) {
            b.append("availBalanceDate: ").append(availBalanceDate.toString()).append('\n');
        }

        for (ImportTransaction t : getTransactions()) {
            b.append(t.toString()).append('\n');
        }

        return b.toString();
    }

    /* <CURDEF>USD
    <BANKACCTFROM>
    <BANKID>074914229
    <ACCTID>10076164
    <ACCTTYPE>CHECKING
    </BANKACCTFROM>
     */
}
