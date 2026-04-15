package generated

final case class Data574(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data574 = copy(name = name.toUpperCase)
  def scale(k: Double): Data574 = copy(value = value * k)
  def addTag(t: String): Data574 = copy(tags = t :: tags)
  def put(k: String, v: String): Data574 = copy(meta = meta.updated(k, v))
  def merge(other: Data574): Data574 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data574 {
  given Ordering[Data574] = Ordering.by(_.id)
  def empty: Data574 = Data574(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data574 =
    Data574(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data574] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
