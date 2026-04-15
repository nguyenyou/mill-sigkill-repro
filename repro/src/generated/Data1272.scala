package generated

final case class Data1272(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1272 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1272 = copy(value = value * k)
  def addTag(t: String): Data1272 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1272 = copy(meta = meta.updated(k, v))
  def merge(other: Data1272): Data1272 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1272 {
  given Ordering[Data1272] = Ordering.by(_.id)
  def empty: Data1272 = Data1272(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1272 =
    Data1272(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1272] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
