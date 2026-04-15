package generated

final case class Data890(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data890 = copy(name = name.toUpperCase)
  def scale(k: Double): Data890 = copy(value = value * k)
  def addTag(t: String): Data890 = copy(tags = t :: tags)
  def put(k: String, v: String): Data890 = copy(meta = meta.updated(k, v))
  def merge(other: Data890): Data890 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data890 {
  given Ordering[Data890] = Ordering.by(_.id)
  def empty: Data890 = Data890(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data890 =
    Data890(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data890] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
