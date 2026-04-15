package generated

final case class Data452(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data452 = copy(name = name.toUpperCase)
  def scale(k: Double): Data452 = copy(value = value * k)
  def addTag(t: String): Data452 = copy(tags = t :: tags)
  def put(k: String, v: String): Data452 = copy(meta = meta.updated(k, v))
  def merge(other: Data452): Data452 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data452 {
  given Ordering[Data452] = Ordering.by(_.id)
  def empty: Data452 = Data452(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data452 =
    Data452(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data452] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
