package com.riiablo.attributes;

import java.util.Iterator;

public final class StatListGetter implements Iterable<StatGetter> {
  final StatList stats;
  final int list;
  final StatGetter tuple = new StatGetter();

  StatListGetter(StatList stats, int list) {
    this.stats = stats;
    this.list = list;
  }

  /** @see StatList#param(int) */
  int param(short stat) {
    return stats.param(indexOf(stat));
  }

  /** @see StatList#value(int) */
  int value(short stat) {
    return stats.value(indexOf(stat));
  }

  /** @see StatList#indexOf(int, short) */
  int indexOf(short stat) {
    return stats.indexOf(list, stat);
  }

  /** @see StatList#contains(int, short) */
  public boolean contains(short stat) {
    return stats.contains(list, stat);
  }

  /** @see StatList#indexOf(int, short) */
  public StatGetter get(short stat) {
    final int index = indexOf(stat);
    if (index < 0) return null;
    return tuple.set(stats, index);
  }

  /** @see StatList#firstIndexOf(int, short) */
  StatGetter first(short stat) {
    final int index = stats.firstIndexOf(list, stat);
    if (index < 0) return null;
    return tuple.set(stats, index);
  }

  public void addAll(StatListGetter src) {
    stats.addAll(list, src.stats, src.list);
  }

  /** @see StatList#indexIterator(int) */
  public StatList.IndexIterator indexIterator() {
    return stats.indexIterator(list);
  }

  /** @see StatList#statIterator(int) */
  public StatList.StatIterator statIterator() {
    return stats.statIterator(list);
  }

  /** @see #statIterator() */
  @Override
  public Iterator<StatGetter> iterator() {
    return statIterator();
  }

  /** @see StatList#listDebugString(int) */
  public String debugString() {
    return stats.listDebugString(list);
  }

  @Override
  public String toString() {
    return debugString();
  }
}
