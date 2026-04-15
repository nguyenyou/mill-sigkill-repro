package generated

final case class Data1051(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1051 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1051 = copy(value = value * k)
  def addTag(t: String): Data1051 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1051 = copy(meta = meta.updated(k, v))
  def merge(other: Data1051): Data1051 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1051 {
  given Ordering[Data1051] = Ordering.by(_.id)
  def empty: Data1051 = Data1051(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1051 =
    Data1051(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1051] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
