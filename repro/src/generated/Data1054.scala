package generated

final case class Data1054(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1054 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1054 = copy(value = value * k)
  def addTag(t: String): Data1054 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1054 = copy(meta = meta.updated(k, v))
  def merge(other: Data1054): Data1054 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1054 {
  given Ordering[Data1054] = Ordering.by(_.id)
  def empty: Data1054 = Data1054(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1054 =
    Data1054(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1054] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
