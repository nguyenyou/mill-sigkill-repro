package generated

final case class Data1146(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1146 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1146 = copy(value = value * k)
  def addTag(t: String): Data1146 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1146 = copy(meta = meta.updated(k, v))
  def merge(other: Data1146): Data1146 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1146 {
  given Ordering[Data1146] = Ordering.by(_.id)
  def empty: Data1146 = Data1146(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1146 =
    Data1146(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1146] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
