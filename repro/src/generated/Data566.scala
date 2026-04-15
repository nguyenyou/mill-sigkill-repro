package generated

final case class Data566(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data566 = copy(name = name.toUpperCase)
  def scale(k: Double): Data566 = copy(value = value * k)
  def addTag(t: String): Data566 = copy(tags = t :: tags)
  def put(k: String, v: String): Data566 = copy(meta = meta.updated(k, v))
  def merge(other: Data566): Data566 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data566 {
  given Ordering[Data566] = Ordering.by(_.id)
  def empty: Data566 = Data566(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data566 =
    Data566(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data566] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
