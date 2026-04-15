package generated

final case class Data806(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data806 = copy(name = name.toUpperCase)
  def scale(k: Double): Data806 = copy(value = value * k)
  def addTag(t: String): Data806 = copy(tags = t :: tags)
  def put(k: String, v: String): Data806 = copy(meta = meta.updated(k, v))
  def merge(other: Data806): Data806 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data806 {
  given Ordering[Data806] = Ordering.by(_.id)
  def empty: Data806 = Data806(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data806 =
    Data806(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data806] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
