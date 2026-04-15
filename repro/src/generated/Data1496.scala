package generated

final case class Data1496(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1496 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1496 = copy(value = value * k)
  def addTag(t: String): Data1496 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1496 = copy(meta = meta.updated(k, v))
  def merge(other: Data1496): Data1496 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1496 {
  given Ordering[Data1496] = Ordering.by(_.id)
  def empty: Data1496 = Data1496(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1496 =
    Data1496(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1496] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
