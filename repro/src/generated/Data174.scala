package generated

final case class Data174(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data174 = copy(name = name.toUpperCase)
  def scale(k: Double): Data174 = copy(value = value * k)
  def addTag(t: String): Data174 = copy(tags = t :: tags)
  def put(k: String, v: String): Data174 = copy(meta = meta.updated(k, v))
  def merge(other: Data174): Data174 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data174 {
  given Ordering[Data174] = Ordering.by(_.id)
  def empty: Data174 = Data174(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data174 =
    Data174(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data174] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
