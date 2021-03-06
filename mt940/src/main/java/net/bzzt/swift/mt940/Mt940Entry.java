package net.bzzt.swift.mt940;
/*
 * Copyright (C) 2008 Arnout Engelen
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


import java.math.BigDecimal;
import java.util.Date;

public class Mt940Entry {
    // 'Credit', in mt940, means money was transferred 
    // to the current account.
    public enum SollHabenKennung {
        CREDIT,
        DEBIT,
        STORNO_DEBIT,
        STORNO_CREDIT
    }

    private Date valutaDatum;

    private SollHabenKennung sollHabenKennung;

    private BigDecimal betrag;

    private String mehrzweckfeld;

    public Date getValutaDatum() {
        return (Date) valutaDatum.clone();
    }

    public void setValutaDatum(Date valutaDatum) {
        this.valutaDatum = (Date) valutaDatum.clone();
    }

    @Override
    public String toString() {
        return "At " + valutaDatum + ", " + sollHabenKennung + ": " + betrag + " for " + mehrzweckfeld;
    }

    public SollHabenKennung getSollHabenKennung() {
        return sollHabenKennung;
    }

    public void setSollHabenKennung(SollHabenKennung sollHabenKennung) {
        this.sollHabenKennung = sollHabenKennung;
    }

    public String getMehrzweckfeld() {
        return mehrzweckfeld;
    }

    public void setMehrzweckfeld(String mehrzweckfeld) {
        this.mehrzweckfeld = mehrzweckfeld;
    }

    public BigDecimal getBetrag() {
        return betrag;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

	public void addToMehrzweckfeld(String string) {
		if (mehrzweckfeld == null || "".equals(mehrzweckfeld.trim()))
		{
			mehrzweckfeld = string;
		}
		else
		{
			mehrzweckfeld += " ";
			mehrzweckfeld += string;
		}
	}
}
