package generated

final case class Data267(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data267 = copy(name = name.toUpperCase)
  def scale(k: Double): Data267 = copy(value = value * k)
  def addTag(t: String): Data267 = copy(tags = t :: tags)
  def put(k: String, v: String): Data267 = copy(meta = meta.updated(k, v))
  def merge(other: Data267): Data267 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data267 {
  given Ordering[Data267] = Ordering.by(_.id)
  def empty: Data267 = Data267(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data267 =
    Data267(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data267] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
