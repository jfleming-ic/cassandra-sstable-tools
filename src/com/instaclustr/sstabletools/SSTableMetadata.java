package com.instaclustr.sstabletools;

import java.util.Comparator;

/**
 * Metadata statistics about sstable.
 */
public class SSTableMetadata {
    public final static Comparator<SSTableMetadata> DTCS_COMPARATOR = new Comparator<SSTableMetadata>() {
        @Override
        public int compare(SSTableMetadata o1, SSTableMetadata o2) {
            int cmp = Long.compare(o1.minTimestamp, o2.minTimestamp);
            return cmp == 0 ? Integer.compare(o1.generation, o2.generation) : cmp;
        }
    };

    public final static Comparator<SSTableMetadata> TWCS_COMPARATOR = new Comparator<SSTableMetadata>() {
        @Override
        public int compare(SSTableMetadata o1, SSTableMetadata o2) {
            int cmp = Long.compare(o1.maxTimestamp, o2.maxTimestamp);
            return cmp == 0 ? Integer.compare(o1.generation, o2.generation) : cmp;
        }
    };

    public final static Comparator<SSTableMetadata> GENERATION_COMPARATOR = new Comparator<SSTableMetadata>() {
        @Override
        public int compare(SSTableMetadata o1, SSTableMetadata o2) {
            return Integer.compare(o1.generation, o2.generation);
        }
    };

    public final static Comparator<SSTableMetadata> LEVEL_COMPARATOR = new Comparator<SSTableMetadata>() {
        @Override
        public int compare(SSTableMetadata o1, SSTableMetadata o2) {
            int cmp = Long.compare(o1.level, o2.level);
            return cmp == 0 ? Integer.compare(o1.generation, o2.generation) : cmp;
        }
    };

    /**
     * File name of SSTable Data.db.
     */
    public String filename;

    /**
     * SSTable generation.
     */
    public int generation;

    public long minTimestamp;

    public long maxTimestamp;

    public int minLocalDeletionTime;

    public int maxLocalDeletionTime;

    public long fileTimestamp;

    public long diskLength;

    public long uncompressedLength;

    public long keys;

    public long maxRowSize;

    public long avgRowSize;

    public long maxColumnCount;

    public long avgColumnCount;

    public double droppableTombstones;

    public boolean isRepaired;

    public long repairedAt;

    public int level;
}
