package generated

final case class Data428(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data428 = copy(name = name.toUpperCase)
  def scale(k: Double): Data428 = copy(value = value * k)
  def addTag(t: String): Data428 = copy(tags = t :: tags)
  def put(k: String, v: String): Data428 = copy(meta = meta.updated(k, v))
  def merge(other: Data428): Data428 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data428 {
  given Ordering[Data428] = Ordering.by(_.id)
  def empty: Data428 = Data428(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data428 =
    Data428(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data428] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
