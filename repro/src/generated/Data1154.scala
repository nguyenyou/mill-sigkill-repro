package generated

final case class Data1154(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1154 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1154 = copy(value = value * k)
  def addTag(t: String): Data1154 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1154 = copy(meta = meta.updated(k, v))
  def merge(other: Data1154): Data1154 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1154 {
  given Ordering[Data1154] = Ordering.by(_.id)
  def empty: Data1154 = Data1154(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1154 =
    Data1154(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1154] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
