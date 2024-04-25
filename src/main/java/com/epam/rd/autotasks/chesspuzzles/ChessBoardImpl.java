package com.epam.rd.autotasks.chesspuzzles;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class ChessBoardImpl implements ChessBoard{
    private final Collection<ChessPiece> pieces;

    public ChessBoardImpl(Collection<ChessPiece> pieces) {
        this.pieces = pieces;
    }
    @Override
    public String state() {
        StringBuilder sb = new StringBuilder();
        Map<Cell, Character> cellToChar = pieces.stream().collect(Collectors.toMap(ChessPiece::getCell, ChessPiece::toChar));
        for (int i = 1; i <= 8; i++) {
            for (char j = 'A'; j <= 'H'; j++) {
                Cell cell = Cell.cell(j, i);
                if (cellToChar.containsKey(cell)) {
                    sb.append(cellToChar.get(cell));
                } else {
                    sb.append(".");
                }
            }
            if (i != 8) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
