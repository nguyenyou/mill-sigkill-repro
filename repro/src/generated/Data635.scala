package generated

final case class Data635(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data635 = copy(name = name.toUpperCase)
  def scale(k: Double): Data635 = copy(value = value * k)
  def addTag(t: String): Data635 = copy(tags = t :: tags)
  def put(k: String, v: String): Data635 = copy(meta = meta.updated(k, v))
  def merge(other: Data635): Data635 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data635 {
  given Ordering[Data635] = Ordering.by(_.id)
  def empty: Data635 = Data635(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data635 =
    Data635(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data635] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
