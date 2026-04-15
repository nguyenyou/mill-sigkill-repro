package generated

final case class Data944(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data944 = copy(name = name.toUpperCase)
  def scale(k: Double): Data944 = copy(value = value * k)
  def addTag(t: String): Data944 = copy(tags = t :: tags)
  def put(k: String, v: String): Data944 = copy(meta = meta.updated(k, v))
  def merge(other: Data944): Data944 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data944 {
  given Ordering[Data944] = Ordering.by(_.id)
  def empty: Data944 = Data944(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data944 =
    Data944(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data944] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
