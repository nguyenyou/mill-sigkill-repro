package generated

final case class Data434(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data434 = copy(name = name.toUpperCase)
  def scale(k: Double): Data434 = copy(value = value * k)
  def addTag(t: String): Data434 = copy(tags = t :: tags)
  def put(k: String, v: String): Data434 = copy(meta = meta.updated(k, v))
  def merge(other: Data434): Data434 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data434 {
  given Ordering[Data434] = Ordering.by(_.id)
  def empty: Data434 = Data434(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data434 =
    Data434(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data434] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
