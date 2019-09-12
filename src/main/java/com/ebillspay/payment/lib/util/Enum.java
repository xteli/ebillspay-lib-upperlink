/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xteli
 */
public class Enum {

  

    public enum OperationName {

        Ping,
        Reset,
        MakePayment,
        Report;
    }

  

    public enum Channel {

        Nil(0),
        BankTeller(1),
        InternetBanking(2),
        Mobile(3),
        POS(4),
        ATM(5),
        MerchantWebPortal(6),
        ThirdPartyPaymentPlatform(7),
        USSD(8),
        Others(9);

        private int enumValue;

        Channel(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {
            return enumValue;
        }

        private static final Map<Integer, Channel> channelMap = new HashMap<Integer, Channel>();

        static {
            for (Channel channel : Channel.values()) {
                channelMap.put(channel.enumValue, channel);
            }
        }

        public static Channel toEnum(int i) {
            Channel pChannel = channelMap.get(i);
            return pChannel;
        }

    }

}
