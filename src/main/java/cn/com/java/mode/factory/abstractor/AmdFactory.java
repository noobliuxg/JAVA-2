package cn.com.java.mode.factory.abstractor;

public class AmdFactory extends AbstractFactory{

    @Override
    public Cpu buildCpu() {
        return new AmdCpu();
    }

    @Override
    public Board buildBoard() {
        return new AmdBoard();
    }

    @Override
    public Computer builder() {
        AmdComputer amdComputer = new AmdComputer();
        amdComputer.setBoardAware(this.buildBoard());
        amdComputer.setCpu(this.buildCpu());
        return amdComputer;
    }

    class AmdComputer implements Computer,CpuAware,BoardAware{
        private Cpu cpu;
        private Board board;

        @Override
        public void setBoardAware(Board board) {
            this.board = board;
        }

        @Override
        public Cpu getCpu() {
            return cpu;
        }

        @Override
        public Board getBoard() {
            return board;
        }

        @Override
        public void setCpu(Cpu cpu) {
            this.cpu = cpu;
        }
    }
}
