/*
 *  This file is part of the noOp organization .
 *
 *  (c) Cyrille Lebeaupin <clebeaupin@noop.fr>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 *
 */

package fr.noop.charset.iso6937;

import java.util.HashMap;

/**
 * Created by clebeaupin on 29/09/15.
 */
public class Iso6937CharsetMapping {
    private static HashMap<Integer, Integer> encodingMapping = new HashMap();
    private static HashMap<Integer, Integer> decodingMapping = new HashMap();

    static {
        add(0xa4, 0xa8);
        add(0xa6, 0xd7);
        add(0xa9, 0xd3);
        add(0xaa, 0xe3);
        add(0xac, 0xd6);
        add(0xad, 0xff);
        add(0xae, 0xd2);
        add(0xf7, 0xb8);
        add(0x300, 0xc1);
        add(0x301, 0xc2);
        add(0x302, 0xc3);
        add(0x303, 0xc4);
        add(0x304, 0xc5);
        add(0x306, 0xc6);
        add(0x307, 0xc7);
        add(0x308, 0xc8);
        add(0x30a, 0xca);
        add(0x327, 0xcb);
        add(0x30b, 0xcd);
        add(0x328, 0xce);
        add(0x30c, 0xcf);
    }

    public static void add(int x, int y) {
        encodingMapping.put(x, y);
        decodingMapping.put(y, x);
    }

    public static int encode(int x) {
        if (!encodingMapping.containsKey(x)) {
            // Do not encode this char
            return x;
        }

        return encodingMapping.get(x);
    }

    public static int decode(int y) {
        if (!decodingMapping.containsKey(y)) {
            // Do not decode this char
            return y;
        }

        return decodingMapping.get(y);
    }

}
