package generated

final case class Data942(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data942 = copy(name = name.toUpperCase)
  def scale(k: Double): Data942 = copy(value = value * k)
  def addTag(t: String): Data942 = copy(tags = t :: tags)
  def put(k: String, v: String): Data942 = copy(meta = meta.updated(k, v))
  def merge(other: Data942): Data942 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data942 {
  given Ordering[Data942] = Ordering.by(_.id)
  def empty: Data942 = Data942(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data942 =
    Data942(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data942] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
