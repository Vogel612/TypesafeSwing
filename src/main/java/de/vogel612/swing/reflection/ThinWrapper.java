package de.vogel612.swing.reflection;

/**
 * Created by vogel612 on 07.10.15.
 */
public @interface ThinWrapper {
    // FIXME generate source code by overriding wrapped methods
    // check with lombok how the carp they did that and do some dark magic :D
    String field();
    Class<?> type();
}
