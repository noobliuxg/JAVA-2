package cn.com.java.mode.factory.abstractor;

public class IntelFactory extends AbstractFactory{
    @Override
    public Cpu buildCpu() {
        return new IntelCpu();
    }

    @Override
    public Board buildBoard() {
        return new IntelBoard();
    }

    @Override
    public Computer builder() {
        IntelComputer intelComputer = new IntelComputer();
        intelComputer.setBoardAware(this.buildBoard());
        intelComputer.setCpu(this.buildCpu());
        return intelComputer;
    }

    class IntelComputer implements Computer,CpuAware,BoardAware{
        private Cpu cpu;
        private Board board;

        @Override
        public Cpu getCpu() {
            return cpu;
        }

        @Override
        public Board getBoard() {
            return board;
        }

        @Override
        public void setBoardAware(Board board) {
            this.board = board;
        }

        @Override
        public void setCpu(Cpu cpu) {
            this.cpu = cpu;
        }
    }
}
