package generated

final case class Data420(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data420 = copy(name = name.toUpperCase)
  def scale(k: Double): Data420 = copy(value = value * k)
  def addTag(t: String): Data420 = copy(tags = t :: tags)
  def put(k: String, v: String): Data420 = copy(meta = meta.updated(k, v))
  def merge(other: Data420): Data420 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data420 {
  given Ordering[Data420] = Ordering.by(_.id)
  def empty: Data420 = Data420(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data420 =
    Data420(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data420] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
