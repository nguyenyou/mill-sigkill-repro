package generated

final case class Data356(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data356 = copy(name = name.toUpperCase)
  def scale(k: Double): Data356 = copy(value = value * k)
  def addTag(t: String): Data356 = copy(tags = t :: tags)
  def put(k: String, v: String): Data356 = copy(meta = meta.updated(k, v))
  def merge(other: Data356): Data356 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data356 {
  given Ordering[Data356] = Ordering.by(_.id)
  def empty: Data356 = Data356(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data356 =
    Data356(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data356] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
