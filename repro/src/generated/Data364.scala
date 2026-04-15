package generated

final case class Data364(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data364 = copy(name = name.toUpperCase)
  def scale(k: Double): Data364 = copy(value = value * k)
  def addTag(t: String): Data364 = copy(tags = t :: tags)
  def put(k: String, v: String): Data364 = copy(meta = meta.updated(k, v))
  def merge(other: Data364): Data364 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data364 {
  given Ordering[Data364] = Ordering.by(_.id)
  def empty: Data364 = Data364(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data364 =
    Data364(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data364] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
